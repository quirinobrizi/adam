angular
  .module('swarm.containers')
  .component('swarmContainers', {
    templateUrl: 'js/swarm-containers/swarm-containers.template.html',
    controller: ['Swarm', '$routeParams',
      function SwarmDetailController(Swarm, $routeParams) {
        var self = this;

        self.swarmId = $routeParams.swarmId;
        self.containers = Swarm.containers({
          swarmId: self.swarmId
        });

        self.doInContainer = function(swarmId, containerId, action) {
          self.swarm = Swarm.doInContainer({
            swarmId: swarmId,
            containerId: containerId,
            action: action
          });
        };
      }
    ]
  });