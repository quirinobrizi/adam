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
        '$scope', 'Swarm',
        function SwarmStatisticsController($scope, Swarm) {
          $scope.getSwarmStatistics = function(swarm) {
            $scope.swarmId = swarm;
            $scope.statistics = Swarm.getSwarmStatistics({
              swarmId: swarm
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