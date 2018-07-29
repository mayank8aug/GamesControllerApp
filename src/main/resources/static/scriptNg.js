angular.module('gameApp', [])
    .controller('mainController', function($scope) {
        $scope.sortType     = 'title';
        $scope.sortReverse  = false;
        $scope.searchGame = '';
        $scope.pageNo = 1;
        $scope.count = 0;
        $scope.getPagedData = function() {
        		$.ajax({
                    method: 'GET',
                    url: 'http://localhost:8181/get',
                    data: {
                        pageNo : $scope.pageNo,
                        sortType: $scope.sortType,
                        sortOrder: $scope.sortReverse ? 'desc' : 'asc',
                        searchQuery: $scope.searchGame
                    },
                    success: function(resp) {
                        $scope.games = resp.data;
                        $scope.count = Math.ceil(resp.count/10);
                        if (!$scope.$$phase) {
                            $scope.$apply();
                        }
                    }
                });
        }
        $scope.getPagedData();
        $scope.getPagedDataOnEnter = function(keyEvent) {
        	if (keyEvent.which === 13)
        		this.getPagedData();
        	}
    });