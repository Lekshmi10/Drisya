$(document).ready(function(){
    // NEWS EVENT FORM SLIDE SHOW


        $('#home_preview').css('pointer-events','visible');
        $('#home_preview').css('opacity','1');

    $('.open-news-form').click(function(e){
        e.preventDefault()
        $(this).hide();
        $('#news-event-modal').slideToggle();
    });
    $('.clear-news-form').click(function(e){
        e.preventDefault();
        $('#news-event-modal').slideToggle();
        $('.open-news-form').show();
    });

    $('.nav-menu-list').click(function(e){
        e.preventDefault();
        $('.nav-menu-list.active').removeClass('active');
        $(this).addClass('active');
        var dragId = $(this).data('menu');
        $('.tab-body-homepage.active').removeClass('active');
        $('#'+ dragId).addClass('active');
    });
    $('.tab-navigation').click(function(e){
        e.preventDefault();
        $('.tab-navigation.active').removeClass('active');
        $(this).addClass('active');
        var refTabId = $(this).data('reftab');
        $('.ref-tab-list.active').removeClass('active');
        $('.support-tab-list.active').removeClass('active');
        $('.application-tab-list.active').removeClass('active');
        $('#'+ refTabId).addClass('active');
    });

    $(document).on('click','.edit-list', function(e){
        e.preventDefault();
        $(".ctrl-btn").css('pointer-events','none');
        $(".ctrl-btn").css('opacity','0.5');
        $(this).parents('.drag-list').addClass('edit');
    });

    $(document).on('click','.save-list', function(e){
        e.preventDefault();
        $(this).parents('.drag-list').removeClass('edit');
        $(".ctrl-btn").css('pointer-events','visible');
        $(".ctrl-btn").css('opacity','1');
    });

    $('.toggle-button').click(function(e){
        e.preventDefault();
        $('.template-sidebar').toggleClass('collapse-menu');
    });
    $('.tost-top').click(function(e){
        e.preventDefault();
        $('.tost-top').toggleClass('open');
        $('.tost-top').find('p').remove();
    });

});

$( function() {
    if ($(".drag-menu-row")[0]){
        $(".drag-menu-row").sortable();
    }
});

$(document).on('click','.news-edit', function () {
    $(this).hide();
    $(this).parents('.news-list').find('.edit-news').slideToggle();
});


$(document).on('click','.edit-blurb', function () {
    $(this).hide();
    $(this).parents('.blurbs').find('.edit-blurb-row').slideToggle();
    $(".ctrl-btn").css('pointer-events','none');
    $(".ctrl-btn").css('opacity','0.5');
});

$(document).on('click','.update-blurb', function () {
    $(this).parents('.blurbs').find('.edit-blurb-row').slideToggle();
    $(this).parents('.blurbs').find('.edit-blurb').show();
    $(".ctrl-btn").css('pointer-events','visible');
    $(".ctrl-btn").css('opacity','1');
});

$(document).on('click', '#home_blurbs .blurbs .delete-list', function () {
    $(this).parents('.blurbs').remove();
});

//NEWS & EVENTS
$(document).on('click', '#news-fetchList .news-list .delete-list', function () {
    $(this).parents('.news-list').remove();
});



