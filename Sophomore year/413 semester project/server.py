import socket
import threading
import threading
import json

# Creates a dictionary of the usernames
client_names = {}

# Runs a thread for every new user, conn is the connection object and addr is the IP address
def directing_client(cli_socket, addr):
    # initalizing username
    username = None

    try:
        # receives the first data which is the username then decodes it back into a string
        initial_data = cli_socket.recv(1024).decode('utf-8')
        # turns the string in to a python dictionary
        registration = json.loads(initial_data)
        # gets the username from the ditcionary
        username = registration.get("sender")
        # saves the connection object in the dictionary
        client_names[username] = cli_socket

        # notifies that the new user has joined the server
        print(f"[REGISTERED] {username} joined the ClassChat.")

        # a loop that is listenting for new messages
        while True:
            # the data can be upto 10KB
            data = cli_socket.recv(10240).decode('utf-8') 
            # if no data that means the client is disconnected and breaks the loop
            if not data: break
            
            # turns the incoming data back into a pyhton dictionary
            payload = json.loads(data)
            receiver = payload.get("receiver")
             # if the client is sending to all then it loops through every user except sender and sends the message
            if receiver == "ALL":
                for user, socket_obj in client_names.items():
                    if user != username: 
                        # sends the encoded string to the user socket connection object
                        socket_obj.send(data.encode('utf-8'))

            # if the receiver macthes a name in the dictoinary then the string is sent to that user
            elif receiver in client_names:
                client_names[receiver].send(data.encode('utf-8'))
            
            #if the receiver is neither ALL or a mathcing name then it sends an error code back to client
            else:
                # making error code string
                error = json.dumps({
                    "sender": "Server", 
                    "text": f"User {receiver} is not in the system."
                })
                # sending error string
                cli_socket.send(error.encode('utf-8'))

    # error exception            
    except Exception as e:
        print(f"[ERROR] {e}")
    # if the user logs out or unexpectedly disconnects then they are deleted from the dictionary
    finally:
        # checking for user in ditionary
        if username in client_names:
            #deleting said user
            del client_names[username]
            # closing connection
        cli_socket.close()
        #print notifying the server
        print(f"[DISCONNECTED] {username} left.")

# starts the server
def server():
    # creating the main socket with IPv4 and TCP
    serv_socket = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    # assiging the server to a local host on port 12345
    serv_IP = '127.0.0.1'
    serv_port = 12345 
    serv_socket.bind((serv_IP, serv_port))
    # server is in listening mode
    serv_socket.listen()
    # notifying the server terminal is active
    print(f"ClassChat server is live")
    
    while True:
        # waits for a new client to join and start a new thread running the directing client def
        cli_socket, addr = serv_socket.accept()
        threading.Thread(target=directing_client, args=(cli_socket, addr)).start()

if __name__ == "__main__":
    server()