/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 *  
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *  
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
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
        removeContainer: {
          method: 'DELETE',
          url: 'swarms/:swarmId/containers/:containerId',
          headers: {
            'Authorization': 'Basic bGlnaHRob3VzZTpsaWdodGhvdXNl'
          }
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