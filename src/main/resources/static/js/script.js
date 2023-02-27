var socket = new WebSocket("ws://localhost:8888/vtswebapiestados/web-socket");
socket.onmessage = function(event) {
    if (event.data === "new-notification") {
        alert("nova notificação")
    }
};