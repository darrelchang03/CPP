from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import hashes, hmac, serialization
from cryptography.hazmat.primitives.serialization import load_pem_private_key
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
from cryptography.exceptions import InvalidSignature
import os

class Receiver: 
    def __init__(self):
        generate_keys(user="receiver")
        self.public_key_path = "receiver/public_info/receiver_public_key.pem"
        self.__private_key_path =  "receiver/private/receiver_private_key.pem"

    def decrypt_message(self, encrypted_data_path):
        receiver_private_key_path = self.__private_key_path
        # Load encrypted data
        with open(encrypted_data_path, "rb") as f:
            data = f.read()

        # Extract components: IV, encrypted message, and encrypted AES key
        iv = data[:16]
        encrypted_message = data[16:-256-32]
        mac = data[-256-32:-256]
        encrypted_keys = data[-256:]
        
        # debugging
        # print("IV Length:", len(iv))
        # print("Encrypted Message Length:", len(encrypted_message))
        # print("MAC Length:", len(mac))
        # print("Encrypted Keys Length:", len(encrypted_keys))

        # load receiver private key from the specified path
        with open(receiver_private_key_path, "rb") as key_file:
            private_key = load_pem_private_key(key_file.read(), password=None, backend=default_backend())

        # Decrypt AES key using receiver's private RSA key
        decrypted_keys = private_key.decrypt(
            encrypted_keys,
            padding.OAEP(
                mgf=padding.MGF1(algorithm=hashes.SHA256()),
                algorithm=hashes.SHA256(),
                label=None
            )
        )
        aes_key = decrypted_keys[:32]
        hmac_key = decrypted_keys[32:]
        
        # debugging
        # print("AES Key Size:", len(aes_key))
        # print("HMAC Key Size:", len(hmac_key))

        # authenticate using hmac
        h = hmac.HMAC(hmac_key, hashes.SHA256(), backend=default_backend())
        h.update(encrypted_message)
        
        try:
            # autheticate before decrypting to prevent ddos threats
            h.verify(mac)
            print("HMAC authentication successful")
            
            # if verifyied with no error, decrypt the message using AES
            cipher = Cipher(algorithms.AES(aes_key), modes.CFB(iv))
            decryptor = cipher.decryptor()
            decrypted_message = decryptor.update(encrypted_message) + decryptor.finalize()
            print("Decrypted message:", decrypted_message.decode())
            
        except InvalidSignature:
            print("HMAC authentication failed: Message has been tampered with or was corrupted")

def generate_keys(user):
    # generate an RSA private key with size 2048 
    private_key = rsa.generate_private_key(
        public_exponent=65537,
        key_size=2048
    )
    
    # generate the corresponding public key for the key generated before
    public_key = private_key.public_key()
    
    # if not already made, create directories which represent public/private info 
    private_dir = f"{user}/private"
    public_dir = f"{user}/public_info"
    os.makedirs(private_dir, exist_ok=True)
    os.makedirs(public_dir, exist_ok=True)

    # save private key to file 
    with open(f"{private_dir}/{user}_private_key.pem", "wb") as f:
        f.write(private_key.private_bytes(
            encoding=serialization.Encoding.PEM,
            format=serialization.PrivateFormat.TraditionalOpenSSL,
            encryption_algorithm=serialization.NoEncryption()
        ))

    # save public key to .pem file
    with open(f"{public_dir}/{user}_public_key.pem", "wb") as f:
        f.write(public_key.public_bytes(
            encoding=serialization.Encoding.PEM,
            format=serialization.PublicFormat.SubjectPublicKeyInfo
        ))