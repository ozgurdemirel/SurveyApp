angular.module('app.services')
    .factory('surveyService', surveyDataService);

function surveyDataService($http,$log) {
    var saveURL = '../resource/survey';

    var data = {
        'save': save
    };


    function save(data) {
        console.log('ajax call');
        return $http(
            {
                'url': saveURL,
                'method': 'POST',
                'headers': {
                    'Content-Type': 'application/json'
                },
                'data': data
            }
        ).then(
            function (response) {
                return response.data;
            }
        ).catch(
            _surveyServiceError
        );
    }

    return data;

    function _surveyServiceError(errorResponse) {
        $log.error('XHR Failed for SurveyService')
        $log.error(errorResponse);
        return errorResponse;
    }


}