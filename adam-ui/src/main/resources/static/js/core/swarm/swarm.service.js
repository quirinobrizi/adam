angular
  .module('core.swarm')
  .factory('Swarm', ['$resource',
    function($resource) {
      return $resource('', {}, {
        swarms: {
          method: 'GET',
          url: 'swarms',
          transformResponse: function(data, headers) {
            return angular.fromJson(data);
          },
          isArray: true,
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          }
        },
        swarm: {
          method: 'GET',
          url: 'swarms/:swarmId',
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          },
          isArray: false
        },
        nodes: {
          method: 'GET',
          url: 'swarms/:swarmId/nodes',
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          },
          isArray: true
        },
        containers: {
          method: 'GET',
          url: 'swarms/:swarmId/containers',
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          },
          isArray: true
        },
        doInContainer: {
          method: 'PUT',
          url: 'swarms/:swarmId/containers/:containerId/:action',
          params: {
            swarmId: '@swarmId',
            containerId: '@containerId',
            action: '@action'
          },
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          }
        },
        getContainerStatistics: {
          method: 'GET',
          url: 'swarms/:swarmId/containers/:containerId/statistics',
          params: {
            swarmId: '@swarmId',
            containerId: '@containerId'
          },
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          }
        },
        getSwarmStatistics: {
          method: 'GET',
          url: 'swarms/:swarmId/statistics',
          params: {
            swarmId: '@swarmId',
            containerId: '@containerId'
          },
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          }
        }
      });
    }
  ]);