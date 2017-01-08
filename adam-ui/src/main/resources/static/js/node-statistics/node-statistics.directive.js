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
  .module('node.statistics')
  .directive('nodeStatistics', function() {
    return {
      restrict: 'E',
      scope: {
        ngDockerVersion: '@',
        ngRunningContainers: '@',
        ngSwarm: '@'
      },
      templateUrl: 'js/node-statistics/node-statistics.template.html',
      controller: [
        '$scope', 'Utils', '$sce',
        function SwarmStatisticsController($scope, Utils, $sce) {
          $scope.utils = Utils;
          $scope.init = function(dockerVersion, runningContainers, swarmId) {
            $scope.displayStatistics = [ 
              {"key":'dockerVersion', "name": $sce.trustAsHtml("Docker Version"), "fcn": "noop"}, 
              {"key":'runningContainers', "name": $sce.trustAsHtml('<a href="#!/swarms/'+swarmId+'/containers">Running Containers</a>'), "fcn": "noop"} ]
            $scope.statistics = {'dockerVersion': dockerVersion, 'runningContainers': runningContainers};
            $scope.swarmId = swarmId;
          };
        }
      ],
      link: function(scope, iElement, iAttrs) {
        scope.init(iAttrs.ngDockerVersion, iAttrs.ngRunningContainers, iAttrs.ngSwarm);
      }
    }
  });