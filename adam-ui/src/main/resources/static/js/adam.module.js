angular
  .module('adam', [
    'ngRoute',
    'angular-growl', 
    'ngFitText',
    'core',
    'swarm.list',
    'swarm.nodes',
    'swarm.containers',
    'container.statistics',
    'node.statistics'
  ]).config(['fitTextConfigProvider', function(fitTextConfigProvider) {
	  fitTextConfigProvider.config = {
    debounce: function(a,b,c) {         // OR specify your own function
      var d;return function(){var e=this,f=arguments;clearTimeout(d),d=setTimeout(function(){d=null,c||a.apply(e,f)},b),c&&!d&&a.apply(e,f)}
    },
    delay: 1000,                        // debounce delay
    loadDelay: 10,                      // global default delay before initial calculation
    compressor: 1,                      // global default calculation multiplier
    min: 0,                             // global default min
    min: 'inherit',                     // OR inherit CSS values globally
    max: Number.POSITIVE_INFINITY,       // global default max
    max: 'inherit'                      // OR inherit CSS values globally
  };
}]);