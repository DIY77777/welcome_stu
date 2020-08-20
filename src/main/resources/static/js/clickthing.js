$(function () {
                // 定义：存储验证码
                var verifyCode = new GVerify("v_container");
                // 登录的js验证
                $("#submit1").click(function () {
                    Stuisnull();
                    if($("#user_name").val().length == 11){
                        $("#user_name").attr("name","Telphone");
                    }else{
                        $("#user_name").attr("name","StuNumber");
                    }
                    var res = verifyCode.validate(document.getElementById("auth_code").value);  //获取验证码
                    // 判断：输入框里验证码和获取到的验证码是否一致
                    if (res) {   //如果一样就验证成功
                        $("#stulogin").submit();
                        console.log("验证成功的操作；");
                    }else if (res.length <1){   //验证码输入的长度=等于0，就提示验证码错误
                        console.log("验证码错误的操作；");
                        $("#code_hi").show();
                        verifyCode;  //重新刷新验证码
                        return;
                    } else {   //如不一致，就验证错误
                        console.log("验证码错误的操作；");
                        verifyCode;  //重新刷新验证码
                        return;
                    }
                });
                $("#submit2").click(function (){
                    var name_ad = $("#admin_name").val();
                    var pwd_ad = $("#admin_pwd").val();
                    if(name_ad==null || name_ad==''){
                        $("#name_tip").show();
                        return;
                    }
                    if(pwd_ad==null || pwd_ad==''){
                        $("#pwd_tip").show();
                        return;
                    }
                    if(isSeccess == 1){
                        $("#admlogin").submit();
                    }
                });
});
            function Stuisnull(){
                var name = $("#user_name").val();
                var pwd = $("#user_pwd").val();
                if(name==null || name==''){
                    $("#username_hi").show();
                    return;
                }
                if(pwd==null || pwd==''){
                    $("#pwd_hi").show();
                    return;
                }
                return true;
            }
