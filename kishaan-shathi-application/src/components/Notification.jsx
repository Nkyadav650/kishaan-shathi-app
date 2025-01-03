import React, { useEffect, useState } from 'react';
import SockJS from 'sockjs-client';
import { Client } from '@stomp/stompjs';

const Notification = () => {
    const [notifications, setNotifications] = useState([]);
    const [stompClient, setStompClient] = useState(null);
    const [userId, setUserId] = useState(''); // State for user ID input
    const [message, setMessage] = useState(''); // State for notification message

    useEffect(() => {
        const client = new Client({
            webSocketFactory: () => new SockJS('http://localhost:2024/ws'),
            reconnectDelay: 5000,
            onConnect: () => {
                console.log('Connected to WebSocket');
                client.subscribe('/topic/notifications', (message) => {
                    const notification = JSON.parse(message.body);
                    console.log('Received notification:', notification);
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

    const sendNotificationToUser = () => {
        if (stompClient && userId && message) {
            const notification = {
                message,
                notificationType: "User Specific",
                userId,
                isRead: false,
                dateCreated: new Date(),
            };
            stompClient.publish({
                destination: `/app/sendNotification`,
                body: JSON.stringify(notification),
            });
            console.log(`Notification sent to user with ID: ${userId}`);
        } else {
            alert('Please enter a user ID and message.');
        }
    };

    const sendNotificationToAll = () => {
        if (stompClient && message) {
            const notification = {
                message,
                notificationType: "Broadcast",
                userId: null, // Not needed for broadcast
                isRead: false,
                dateCreated: new Date(),
            };
            stompClient.publish({
                destination: `/app/sendToAll`,
                body: JSON.stringify(notification),
            });
            console.log('Notification sent to all users.');
        } else {
            alert('Please enter a message to broadcast.');
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
            <div>
                <input
                    type="text"
                    placeholder="Enter user ID"
                    value={userId}
                    onChange={(e) => setUserId(e.target.value)}
                />
                <input
                    type="text"
                    placeholder="Enter message"
                    value={message}
                    onChange={(e) => setMessage(e.target.value)}
                />
                <button onClick={sendNotificationToUser}>Send Notification to User</button>
                <button onClick={sendNotificationToAll}>Send Notification to All</button>
            </div>
        </div>
    );
};

export default Notification;
