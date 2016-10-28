angular
  .module('core.notify')
  .factory('Notify', [function() {
  	var stomp = null,
        connected = false;
  	return {
  		connect: function(url, callback) {
        if(!connected) {
        	stomp = Stomp.over(new SockJS(url));
        	stomp.connect({}, function() {
            connected = true;
            callback();
          });
        	stomp.onclose = this.reconnect;
        } else {
          callback();
        }
  		},
  		subscribe: function(channel, callback) {
  			stomp.subscribe(channel, callback);
  		},
  		reconnect: function() {
	  		setTimeout(this.connect, 10000);
	  	},
      disconnect: function() {
        stomp.disconnect();
      }
  	};
  }]);