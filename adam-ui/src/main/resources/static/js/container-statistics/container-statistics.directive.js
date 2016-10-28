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
  .module('container.statistics')
  .directive('containerStatistics', function() {
    return {
      restrict: 'E',
      // require: ['^ngSwarm', '^ngContainer'],
      scope: {
        ngSwarm: '@',
        ngContainer: '@'
      },
      templateUrl: 'js/container-statistics/container-statistics.template.html',
      controller: [
        '$scope', 'Swarm',
        function ContainerStatisticsController($scope, Swarm) {
          $scope.memoryLabels = ['Used (MB)', 'total (MB)'];
          $scope.memoryOptions = {
            'title': {
              'display': true,
              'text': "Memory Usage (MB)"
            }
          };
          $scope.cpuLabels = ['Used (%)', 'Free (%)'];
          $scope.cpuOptions = {
            'title': {
              'display': true,
              'text': "CPU Usage (%)"
            }
          };
          $scope.colors= [{
            fillColor: 'rgba(213,226,255)',
            strokeColor: 'rgba(213,226,254)',
            pointColor: 'rgba(213,226,254)',
            pointStrokeColor: '#fff',
            pointHighlightFill: '#fff',
            pointHighlightStroke: 'rgba(213,226,255)'
          }, {
            fillColor: 'rgba(185,223,147)',
            strokeColor: 'rgba(185,223,146)',
            pointColor: 'rgba(185,223,146)',
            pointStrokeColor: '#fff',
            pointHighlightFill: '#fff',
            pointHighlightStroke: 'rgba(185,223,147)'
          }];
          $scope.getContainerStatistics = function(swarm, container) {
            Swarm.getContainerStatistics({
              swarmId: swarm,
              containerId: container
            }).$promise.then(
              // success
              function(statistics) {
                // $scope.statistics = statistics;
                // $scope.cpuUsageChartConfig = prepareCpuUsageChartConfig(statistics);
                $scope.memoryStatistics = [
                  [$scope.formatBytes(statistics.memoryUsage, 2), $scope.formatBytes(statistics.totalMemory, 2)]
                ];
                $scope.cpuUsageStatistics = [
                  [statistics.cpuUsage, 100 - statistics.cpuUsage]
                ];
              }
            );
          };

          $scope.formatBytes = function(bytes, decimals) {
            if (bytes == 0) {
              return '0';
            }
            var k = 1000; // or 1024 for binary
            var dm = decimals + 1 || 3;
            var sizes = ['Bytes', 'KB', 'MB', 'GB', 'TB', 'PB', 'EB', 'ZB', 'YB'];
            var i = Math.floor(Math.log(bytes) / Math.log(k));
            return parseFloat((bytes / Math.pow(k, 2)).toFixed(dm)); // + ' ' + sizes[i];
          };

          $scope.calculatePercentage = function(current, maximum) {
            return (current * 100) / maximum;
          };
        }
      ],
      link: function(scope, iElement, iAttrs) {
        scope.getContainerStatistics(iAttrs.ngSwarm, iAttrs.ngContainer);
      }
    }
  });