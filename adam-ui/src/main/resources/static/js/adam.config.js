angular.module('adam')
  .config(['$locationProvider', '$routeProvider', 'growlProvider',
    function config($locationProvider, $routeProvider, growlProvider) {
      growlProvider.globalTimeToLive(10000);
      $locationProvider.hashPrefix('!');
      $routeProvider.
        when('/swarms', {
          template: '<swarm-list></swarm-list>'
        }).
        when('/swarms/:swarmId/nodes', {
          template: '<swarm-nodes></swarm-nodes>'
        }).
        when('/swarms/:swarmId/containers', {
          template: '<swarm-containers></swarm-containers>'
        }).
        otherwise('/swarms');
    }
  ])
  .run(['Notify', 'growl', function(Notify, growl) {
    Notify.connect('http://localhost:8080/adam-websocket', function() {
      Notify.subscribe('/topic/swarm/events', function(event) {
        if(event) {
          var message = angular.fromJson(event.body)
          if("START" === action) {
            growl.info(message.source + "    " + message.action);
          } else if("STOP" === action) {
            growl.warn(message.source + "    " + message.action); 
          }
        }
      });
    });
  }]);