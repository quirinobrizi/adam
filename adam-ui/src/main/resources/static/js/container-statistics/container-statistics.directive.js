/*******************************************************************************
 * Copyright [2016] [Quirino Brizi (quirino.brizi@gmail.com)]
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 ******************************************************************************/
angular.module('container.statistics').directive('containerStatistics', function() {
  return {
    restrict : 'E',
    // require: ['^ngSwarm', '^ngContainer'],
    scope : {
      ngSwarm : '@',
      ngContainer : '@'
    },
    templateUrl : 'js/container-statistics/container-statistics.template.html',
    controller : [ '$scope', 'Swarm', 'Utils', function ContainerStatisticsController($scope, Swarm, Utils) {
      $scope.utils = Utils;
      $scope.displayStatistics = [ 
        {"key":'totalMemory', "name": "Total Memory", "fcn": "formatBytes"}, 
        {"key":'memoryUsage', "name": "Memory in Use", "fcn": "formatBytes"},
        {"key":'maxMemoryUsage', "name": "Max Used Memory", "fcn": "formatBytes"},
        {"key":'failCount', "name": "Memory Failures", "fcn": "noop"},
        {"key":'cpuUsage', "name": "CPU in Use", "fcn": "formatCpuPercentage"} ]
      $scope.getContainerStatistics = function(swarm, container) {
        $scope.statistics = Swarm.getContainerStatistics({
          swarmId : swarm,
          containerId : container
        });
      };      
    } ],
    link : function(scope, iElement, iAttrs) {
      scope.getContainerStatistics(iAttrs.ngSwarm, iAttrs.ngContainer);
    }
  }
});