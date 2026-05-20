import socket
import threading
import json

# function that wiats for instructions from server
def handler_direction (cli_socket):
    while True:
        try:
            # receives the data from the server
            data = cli_socket.recv(10240).decode('utf-8')
            #if no data break the loop
            if not data: break
            # turn into a dictionary
            payload = json.loads(data)
            #gets the sender from the dictionary
            sender = payload.get("sender")
            
            # if the message was for all label it group, if not label it private
            tag = "[GROUP]" if payload.get("receiver") == "ALL" else "[PRIVATE]"
            # prints the message on the receivers end
            print(f"\n{tag} <{sender}>: {payload.get('text')}")
            
            # allow the user to type again
            print("> ", end="", flush=True)

        except:
            break


def client():
    # connects to the servers main IP and port
    client = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
    client.connect(('127.0.0.1', 12345))
    
    # asks for the users username upon first use
    my_name = input("Enter your ClassChat username: ")
    # sends the username back to server in JSON format and this is the initial data it was waiting on
    client.send(json.dumps({"sender": my_name}).encode('utf-8'))
    
    # starts the handler_direction and will stop when the program closes
    threading.Thread(target=handler_direction, args=(client,), daemon=True).start()

    # promts the user with their options
    print("\n--- Options ---")
    print("Group:   ALL: <message>")
    print("Private: <Name>: <message>")
    print("Disconnect: exit")

    # loop for the input
    while True:
        user_input = input("> ")

        # checks if the user input exit and disconnects from the server
        if user_input.lower().strip() == "exit":
            print("Disconnecting from ClassChat")
            client.close()
            break

        # reads what the user input
        if ":" in user_input:
            target, msg = user_input.split(":", 1)
            # puts the information into a dictionary
            payload = {
                "sender": my_name, 
                "receiver": target.strip(), 
                "text": msg.strip()
            }
            # converts the dictionry into a JSON string encodes it and sends it to the server
            client.send(json.dumps(payload).encode('utf-8'))

if __name__ == "__main__":
    client()