import socket
import threading

# set starting details to make connection and decode messages
HEADER = 64
PORT = 5050
SERVER = socket.gethostbyname(socket.gethostname())
ADDR = (SERVER, PORT)
FORMAT = 'utf-8'
DISCONNECT_MESSAGE = "disconnected"

# start and bind server socket
s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(ADDR)

def send_message(msg, clients, conn):
    # sends message to client that it did not receive the message from
    for client in clients:
        if client != conn:
            client.send(msg.encode(FORMAT))

def send_client_start(conn, symbol, turn):
    # Sends clients their starting information (X or O, who's turn is first) combined
    start_info = f"{symbol}{turn}"
    conn.send(start_info.encode(FORMAT))

def handle_client(conn, addr, clients):
    # receives messsages from clients and sends to opposite client
    print(f"[NEW CONNECTION] {addr} connected")

    connected = True
    while connected:
        msg_length = conn.recv(HEADER).decode(FORMAT)
        if msg_length:
            msg_length = int(msg_length)
            msg = conn.recv(msg_length).decode(FORMAT)
            if msg == DISCONNECT_MESSAGE:
                connected = False
            print(f"[{addr}] {msg}")
            if connected:
                send_message(msg, clients, conn)
    conn.close()

def start():
    # Waits for client connections and sends them their starting information
    clients = []
    symbols = ['O', 'X']
    turns = ['0', '1']  # Assuming the first connected player starts the game
    s.listen(2)
    print(f'Server is listening on {SERVER}')
    while True:
        conn, addr = s.accept()
        clients.append(conn)
        if len(clients) <= 2:
            send_client_start(conn, symbols.pop(0), turns.pop(0))
        else:
            print('[ERROR] Too many players')
        t = threading.Thread(target=handle_client, args=(conn, addr, clients))
        t.start()
        print(f"[ACTIVE CONNECTIONS] {threading.active_count() - 1}")

 
print("[STARTING] server is starting...")
start()
