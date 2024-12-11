from cryptography.hazmat.primitives.asymmetric import rsa, padding
from cryptography.hazmat.primitives import hashes, hmac, serialization
from cryptography.hazmat.primitives.serialization import load_pem_public_key, load_pem_private_key
from cryptography.hazmat.backends import default_backend
from cryptography.hazmat.primitives.ciphers import Cipher, algorithms, modes
import os

'''
1. Get public key of receiver
2. make an aes key (used to encrypt the message)
3. encrypt message with the aes key
3. create MAC for encrypted message (encrypt then mac)
4. encrypt AES key concat with MAC using receiver pub key
5. Save to file: cipher text, hmac, 
'''
class Sender:
    def __init__(self):
        generate_keys(user="sender")
        
    # Usage 
    def encrypt_message(self, message, receiver):
        receiver_public_key_path = receiver.public_key_path
        # load receiver's public key
        with open(receiver_public_key_path, "rb") as key_file:
            public_key = load_pem_public_key(key_file.read(), backend=default_backend())

        # generate a random AES key
        aes_key = os.urandom(32)

        # encrypt the message we want to send with AES key
        iv = os.urandom(16)
        cipher = Cipher(algorithms.AES(aes_key), modes.CFB(iv))
        encryptor = cipher.encryptor()
        encrypted_message = encryptor.update(message.encode()) + encryptor.finalize()
        
        # debugging

        
        # generate HMAC for the encrypted message
        hmac_key = os.urandom(32)  # generating key for hmac
        h = hmac.HMAC(hmac_key, hashes.SHA256(), backend=default_backend())
        h.update(encrypted_message)
        mac = h.finalize()

        # encrypt the AES key + HMAC with the receiver's public RSA key
        encrypted_keys = public_key.encrypt(
            aes_key + hmac_key, # concat aes and hmac keys
            padding.OAEP(
                mgf=padding.MGF1(algorithm=hashes.SHA256()),
                algorithm=hashes.SHA256(),
                label=None
            )
        )
        
        # save encrypted message, AES key, and IV
        with open("Transmitted_Data.txt", "wb") as f:
            f.write(iv + encrypted_message + mac + encrypted_keys)

        print("Message encrypted and saved.")
        
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