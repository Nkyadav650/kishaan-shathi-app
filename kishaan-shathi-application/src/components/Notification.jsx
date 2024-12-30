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
                destination: '/app/sendNotification',
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
