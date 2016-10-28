angular
  .module('swarm.nodes')
  .component('swarmNodes', {
    templateUrl: 'js/swarm-nodes/swarm-nodes.template.html',
    controller: ['Swarm', '$routeParams',
      function SwarmDetailController(Swarm, $routeParams) {
        var self = this;

        self.swarmId = $routeParams.swarmId;
        self.nodes = Swarm.nodes({
          swarmId: self.swarmId
        });
      }
    ]
  });