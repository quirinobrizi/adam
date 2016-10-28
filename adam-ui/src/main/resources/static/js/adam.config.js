angular.module('adam')
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
  ]);