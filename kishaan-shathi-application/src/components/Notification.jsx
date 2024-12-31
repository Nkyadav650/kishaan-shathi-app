import React,{useEffect,useState} from 'react'
import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';
const Notification = () => {
    const [notifications, setNotifications] = useState([]);
    const [stompClient, setStompClient] = useState(null);

    useEffect(() => {
        const socket = new SockJS('/ws');
        const client = new Client({
            webSocketFactory: () => socket,
            onConnect: () => {
                console.log('Connected to WebSocket');
                client.subscribe('/topic/notifications', (message) => {
                    const notification = JSON.parse(message.body);
                    setNotifications((prev) => [...prev, notification]);
                });
            },
        });

        client.activate();
        setStompClient(client);

        return () => {
            if (client) client.deactivate();
        };
    }, []);


    const socket = new WebSocket('ws://localhost:3000/ws/776/dlapvyqs/websocket');
socket.onopen = function(event) {
  console.log("WebSocket connected!");
};
socket.onmessage = function(event) {
  console.log("Message from server:", event.data);
};
socket.onerror = function(error) {
  console.log("WebSocket Error:", error);
};
socket.onclose = function(event) {
  console.log("WebSocket connection closed:", event);
};

    const sendNotification = () => {
        if (stompClient) {
            const notification = {
                message: "New shelling request status",
                notificationType: "Status Update",
                userId: "456",
                isRead: false,
                dateCreated: new Date(),
            };
            stompClient.publish({
                destination: '/sendNotification',
                body: JSON.stringify(notification),
            });
        }
    };

    return (
        <div>
            <h2>Notifications</h2>
            <ul>
                {notifications.map((notification, index) => (
                    <li key={index}>{notification.message}</li>
                ))}
            </ul>
            <button onClick={sendNotification}>Send Notification</button>
        </div>
    );
}

export default Notification
