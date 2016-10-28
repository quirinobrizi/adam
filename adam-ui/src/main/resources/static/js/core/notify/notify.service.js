angular
  .module('core.notify')
  .factory('Notify', [function() {
  	var stomp = null,
  		connected = false;
  	return {
  		connect: function(url, callback) {
          	stomp = Stomp.over(new SockJS(url));
          	stomp.connect({}, function(){ connected = true; });
          	stomp.onclose = reconnect;
  		},
  		subscribe: function(channel, callback) {
  			stomp.subscribe(channel, callback);
  		},
  		reconnect: function() {
	  		setTimeout(this.connect, 10000);
	  	};
  	};
  }]);