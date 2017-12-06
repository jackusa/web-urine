(function ($) {
  $(function () {

    $('.button-collapse').sideNav();

  });


  var lang = $('.dropdown-button');
  lang.dropdown({
      inDuration: 600,
      outDuration: 525,
      hover: true,
      belowOrigin: true
    }
  );

  var isFirstClickLang = true;
  var b = true;
  lang.click(function () {
    if ((screen.width <= 600) && isFirstClickLang) {
      isFirstClickLang = false;
      lang.dropdown({
          inDuration: 600,
          outDuration: 525,
          hover: false,
          belowOrigin: true
        }
      );
    }

    if (b) {
      lang.dropdown('open');
      b = false;
    } else {
      lang.dropdown('close');
      b = true;
    }

  });



  var isFirstClickFab = true;
  var fab = $(".fixed-action-btn");
  fab.click(function () {
    if ((screen.width <= 600) && isFirstClickFab) {
      isFirstClickFab = false;
      fab.closeFAB();
      fab.addClass('click-to-toggle');
      $(".btn-floating").addClass('waves-effect')
    }
  });


  var lis = $('.collapsible li');
  lis.each(function () {

    $(this).click(function () {
      // $(this) --> 指向当前点击的li
      var target_i = $(this).find('i:eq(1)');
      var target_i_text = target_i.text();
      lis.each(function () {
        // 首先把所有箭头向上的icon标签都置为向下
        var i = $(this).find('i:eq(1)');
        if (i.text() !== 'keyboard_arrow_down') {
          i.replaceWith("<i class='material-icons'>keyboard_arrow_down</i>");
        }
      });

      // 然后判断当前icon标签箭头方向再替换方向
      if (target_i_text === 'keyboard_arrow_down') {
        target_i.replaceWith("<i class='material-icons'>keyboard_arrow_up</i>");
      } else {
        target_i.replaceWith("<i class='material-icons'>keyboard_arrow_down</i>");
      }

    });

  });



  $('#create-user').click(function () {
    // todo 在注册按钮点击事件这里进行前端校验
    $.ajax({
      url: '/users',
      type: 'post',
      data: {
        username : $("input[name='username']").val(),
        email : $("input[name='email']").val(),
        phone : $("input[name='phone']").val(),
        password : $("input[name='password']").val()
      },
      dataType: 'json'
    }).done(function (data) {
      if (data.status === 0) {
        new mdui.Dialog('#signUp-success').open();
      } else {
        mdui.alert(data.msg, "注册失败");
      }

      console.log(data);
    });

  });



  $('#login-btn').click(function () {

    $.ajax({
      url: '/authentication/form',
      type: 'post',
      data: {
        username : $("input[name='username']").val(),
        password : $("input[name='password']").val(),
        imageCode: $("input[name='imageCode']").val(),
        'remember-me': $('#filled-in-box').is(':checked')
      },
      success: function() {

        console.log("remember:" + $("input[name='remember-me']").val());
        console.log("filled-in-box:" + $('#filled-in-box').is(':checked'));
        // 跳转到首页
        window.location.assign('index');
      },
      error: function () {
        mdui.alert("请检查账号、密码以及验证码是否正确", "登录失败");
      }
    });

  });








})(jQuery);

