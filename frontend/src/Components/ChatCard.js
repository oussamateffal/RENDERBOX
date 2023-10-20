import React, {useEffect, useRef, useState} from 'react';
import { FaCommentDots, FaPaperPlane, FaTimes } from "react-icons/fa";

const ChatCard = (startChat) => {
    const [showPopup, setShowPopup] = useState(startChat || false);
    const [email, setEmail] = useState('');
    const [messages, setMessages] = useState([]);

    const supportResponses = [
        "Comment puis-je vous aider ?",
        "Pouvez-vous préciser votre demande ?",
        "Je suis là pour vous aider.",
        "Je comprends. Que puis-je faire d'autre pour vous ?"
    ];
    useEffect(() => {
        if (startChat) {
            setShowPopup(true);
        }
    }, [startChat]);
    const sendMessage = (messageText, sender = 'user') => {
        if (messageText.trim() === '') return; // Do not send empty messages

        setMessages(prev => [...prev, { text: messageText, sender }]);
        if (sender === 'user') {
            const randomIndex = Math.floor(Math.random() * supportResponses.length);
            const supportMessage = supportResponses[randomIndex];
            setTimeout(() => {
                setMessages(prev => [...prev, { text: supportMessage, sender: 'support' }]);
            }, 1000);
        }
    }
    const scrollToBottom = () => {
        if (messagesEndRef.current) {
            messagesEndRef.current.scrollTop = messagesEndRef.current.scrollHeight;
        }
    };
    const messagesEndRef = useRef(null);
    useEffect(scrollToBottom, [messages]);

    return (
        <div className="chat-card-container">
            <button className="chat-btn" onClick={() => setShowPopup(!showPopup)}>
                <FaCommentDots size={24} />
            </button>

            {showPopup && (
                <div className="chat-popup">
                    <div className="nav-bar">
                        <h2>Support Chat</h2>
                        <button className="close-btn" onClick={() => setShowPopup(false)}>
                            <FaTimes color="white" />
                        </button>
                    </div>
                    <div className="messages-area" ref={messagesEndRef}>
                        {messages.map((msg, idx) => (
                            <div
                                key={idx}
                                className={`message ${msg.sender}`}
                                style={{ backgroundColor: msg.sender === 'support' ? '#F5F5F5' : '#939292', color: msg.sender === 'support' ? 'black' : 'white' }}
                            >
                                {msg.text}
                            </div>
                        ))}
                    </div>

                        <div className="sender-area">
                            <input type="text" className="send-input" placeholder="Envoyez un message..."
                                   onKeyDown={(e) => {
                                       if (e.key === 'Enter') {
                                           sendMessage(e.target.value);
                                           e.target.value = ''; // Reset input field
                                       }
                                   }}
                            />
                            <button className="send" onClick={() => {
                                const inputElem = document.querySelector('.send-input');
                                sendMessage(inputElem.value);
                                inputElem.value = ''; // Reset input field
                            }}>
                                <FaPaperPlane style={{ color: "white", fontSize: '25px' }} />
                            </button>
                        </div>

                </div>
            )}
        </div>
    );
}

export default ChatCard;
