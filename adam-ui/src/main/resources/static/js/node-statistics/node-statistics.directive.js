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
        '$scope',
        function SwarmStatisticsController($scope) {
          $scope.init = function(dockerVersion, runningContainers, swarmId) {
            $scope.dockerVersion = dockerVersion;
            $scope.runningContainers = runningContainers;
            $scope.swarmId = swarmId;
          };
        }
      ],
      link: function(scope, iElement, iAttrs) {
        scope.init(iAttrs.ngDockerVersion, iAttrs.ngRunningContainers, iAttrs.ngSwarm);
      }
    }
  });