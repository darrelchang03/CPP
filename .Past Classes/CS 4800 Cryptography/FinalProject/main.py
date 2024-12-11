from Receiver import Receiver
from Sender import Sender

'''
To run program:
1) import Receiver and Sender
2) instantiate Sender and Receiver objects
3) Sender can encrypt messages using Sender.encrypt_message(String message, Receiver receiver)
    eg. sender.encrypt_message("Hello world!", receiver)
4) Receiver can decrypt using Receiver.decrypt_message(String path_to_transmitted_data.txt)
    eg. receiver.decrypt_message("Transmitted_Data.txt")
'''

def main():
    sender = Sender()
    receiver = Receiver()

    sender.encrypt_message("Hello world!", receiver)
    receiver.decrypt_message("Transmitted_Data.txt")

if __name__ == "__main__":
    main()
