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
  .module('swarm.statistics')
  .directive('swarmStatistics', function() {
    return {
      restrict: 'E',
      scope: {
        ngSwarm: '@'
      },
      templateUrl: 'js/swarm-statistics/swarm-statistics.template.html',
      controller: [
        '$scope', 'Swarm', 'Utils', '$sce',
        function SwarmStatisticsController($scope, Swarm, Utils, $sce) {
          $scope.utils = Utils;
          $scope.getSwarmStatistics = function(swarmId) { 
            $scope.displayStatistics = [ 
              {"key":'serverVersion', "name": $sce.trustAsHtml('Server Version'), "fcn": "noop"},
              {"key":'containers', "name": $sce.trustAsHtml('<a href="#!/swarms/'+swarmId+'/containers">Containers</a>'), "fcn": "noop"}, 
              {"key":'containersRunning', "name": $sce.trustAsHtml('<a href="#!/swarms/'+swarmId+'/containers">Running Containers</a>'), "fcn": "noop"}, 
              {"key":'containersStopped', "name": $sce.trustAsHtml('<a href="#!/swarms/'+swarmId+'/containers">Stopped Containers</a>'), "fcn": "noop"}, 
              {"key":'containersPaused', "name": $sce.trustAsHtml('<a href="#!/swarms/'+swarmId+'/containers">Paused Containers</a>'), "fcn": "noop"}, 
              {"key":'numberOfNodes', "name": $sce.trustAsHtml('<a href="#!/swarms/'+swarmId+'/nodes">Nodes</a>'), "fcn": "noop"},
              {"key":'ncpu', "name": $sce.trustAsHtml('CPUs'), "fcn": "noop"}, 
              {"key":'totalMemory', "name": $sce.trustAsHtml('Total Memory'), "fcn": "formatBytes"},
//              {"key":'memoryUsage', "name": $sce.trustAsHtml('Memory in Use'), "fcn": "formatBytes"}
            ]
            $scope.swarmId = swarmId;
            $scope.statistics = Swarm.getSwarmStatistics({
              swarmId: swarmId
            });
          };

          $scope.formatBytes = function(bytes, decimals) {
            if(!bytes) {
              return bytes;
            }
            if (bytes == 0) {
              return '0';
            }
            var k = 1000; // or 1024 for binary
            var dm = decimals + 1 || 3;
            var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
            var i = Math.floor(Math.log(bytes) / Math.log(k));
            return parseFloat((bytes / Math.pow(k, i)).toFixed(dm)); // + ' ' + sizes[i];
          };
        }
      ],
      link: function(scope, iElement, iAttrs) {
        scope.getSwarmStatistics(iAttrs.ngSwarm);
      }
    }
  });