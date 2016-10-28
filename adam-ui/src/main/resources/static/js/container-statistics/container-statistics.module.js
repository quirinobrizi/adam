angular
  .module('container.statistics', ['core.swarm', 'chart.js'])
  .config(['ChartJsProvider', function(ChartJsProvider) {
    // Configure all charts
    ChartJsProvider.setOptions({
      // chartColors: ['#FF5252', '#FF8A80'],
      responsive: false
    });
  }]);