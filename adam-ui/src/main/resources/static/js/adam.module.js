angular
  .module('adam', [
    'ngRoute',
    'core',
    'swarm.list',
    'swarm.nodes',
    'swarm.containers',
    'container.statistics',
    'node.statistics'
  ]);