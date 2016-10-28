angular.module('adam', ['core'])
  .config(['$locationProvider', '$routeProvider',
    function config($locationProvider, $routeProvider) {
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
  .run(['Notify', function(Notify) {
    Notify.connect('http://localhost:8080/adam-websocket', function() {
      Notify.subscribe('/topic/swarm/events', function(event) {
        console.log(event);
      });
    });
  }]);