// Define our button click listener
$(window).on("load", function(){
    // Loading Buttons from menu
    valueIndex(1);
    $('#btnNextPage').on("click",()=>functionCall("btnNextPage", '#moreResults', '#loaderScifi'))

})

var indexResult;

function functionCall(index, where, spinner, genre) {
    value = searchIndex(index);

    if (genre==null) {
        url=('/more/' + value);
    } else {
        url=('/moreGenre/'+ genre + '/' + value);
    }

    $.ajax({
        type: "GET",
        contenType: "aplication/json",
        url: url,
        beforeSend: function () {
            $(spinner).removeClass('hidden')
        },
        success: function (result) {
            $(where).append(result);
        },
        complete: function () {
            $(spinner).addClass('hidden')
        },
    });
}

function functionComment(where, spinner) {
    value = indexComment;
    this.indexComment += 1;

    // Search parameter in url
    const arrayPath = window.location.pathname.split('/');
    const id= arrayPath[2];

    url=('/moreComments/' + id + '/' + value);

    $.ajax({
        type: "GET",
        contenType: "aplication/json",
        url: url,
        beforeSend: function () {
            $(spinner).removeClass('hidden')
        },
        success: function (result) {
            $(where).append(result);
        },
        complete: function () {
            $(spinner).addClass('hidden')
        },
    });
}

function functionSearch(index, where, spinner) {
    value = searchIndex(index);

    const queryString = window.location.search;
    const urlParams = new URLSearchParams(queryString);
    const query = urlParams.get('query')

    console.log(query);
    url=('/moreSearch/' + query + '/'+ value);


    $.ajax({
        type: "GET",
        contenType: "aplication/json",
        url: url,
        beforeSend: function () {
            $(spinner).removeClass('hidden')
        },
        success: function (result) {
            $(where).append(result);
        },
        complete: function () {
            $(spinner).addClass('hidden')
        },
    });
}

function searchIndex(index) {
    value = 0;

    switch(index){
        case ("btnTrending"):
            value = indexTrending;
            this.indexTrending += 1;
            break;
        case ("btnAction"):
            value = indexAction;
            this.indexAction += 1;
            break;
        case ("btnAdventure"):
            value = indexAdventure;
            this.indexAdventure += 1;
            break;
        case ("btnAnimation"):
            value = indexAnimation;
            this.indexAnimation += 1;
            break;
        case ("btnComedy"):
            value = indexComedy;
            this.indexComedy += 1;
            break;
        case ("btnDrama"):
            value = indexDrama;
            this.indexDrama += 1;
            break;
        case ("btnHorror"):
            value = indexHorror;
            this.indexHorror += 1;
            break;
        case ("btnScifi"):
            value = indexScifi;
            this.indexScifi += 1;
            break;
        case ("btnSearchUnregistered"):
            value = indexSearchUnregis;
            this.indexSearchUnregis += 1;
            break;
        case ("btnSearchRegistered"):
            value = indexSearchRegis;
            this.indexSearchRegis += 1;
            break;
        case ("btnSearchAdmin"):
            value = indexSearchAdmin;
            this.indexSearchAdmint += 1;
            break;
    }

    return value;
}

function valueIndex(num) {
    this.indexTrending = num;
    this.indexAction = num;
    this.indexAdventure = num;
    this.indexAnimationn = num;
    this.indexComedy = num;
    this.indexDrama = num;
    this.indexHorror = num;
    this.indexScifi = num;

    this.indexComment = num;

    this.indexSearchUnregis = num;
    this.indexSearchRegis = num;
    this.indexSearchAdmin = num;
}