<template>
  <div class="login-wrap">
    <header>
      <div class="logo">
        <img src="../../assets/img/index-logo1.png" height="41" width="105"/>
        <span>中国东信渠道开放平台</span>
      </div>
    </header>
    <main>
      <div class="login-form">
        <div class="login-content">
          <div class="login-group">
            <h3>中国东信渠道开放平台</h3>
          </div>
          <form>
            <div class="login-group">
              <input type="text" placeholder="用户名" v-model="username"/>
            </div>
            <div class="login-group">
              <input type="password" placeholder="密码" v-model="password"/>
            </div>
            <div class="login-group" style="position: relative; top: -15px; margin-bottom: 3px">
              <input type="code" placeholder="验证码" v-model="code" style="padding-right: 0; width: 150px"/>
              <img id="img" @click="getCode" width="100" height="38" style="position: relative; top: 13px"/>
            </div>
            <div class="login-group">
              <button type="button" value="login" @click="login">登录</button>
            </div>
            <div v-show="loading" class="login-group">
              <loading></loading>
            </div>
            <div v-show="!loading" class="login-group">
              <span>{{this.errortext}}</span>
            </div>
          </form>
        </div>
      </div>
    </main>
  </div>

</template>

<script>
  import Loading from '../commom/loading'
  // import md5 from 'js-md5'
  // let base64 = require('js-base64').Base64

  export default {
    name: 'login',
    components: {
      Loading
    },
    data () {
      return {
        username: '',
        password: '',
        date: '',
        code: '',
        islogin: false,
        errortext: '',
        loading: false
      }
    },
    created () {
    },
    mounted () {
      this.getCode()
    },
    methods: {
      // checkParam (param) {
      //   if (param === '') {
      //     alert('您的登录信息不可为空！')
      //     return false
      //   }
      //   let reg = /[ ~!@#$%^&*()+={}|;:'",./<>?]+/
      //   if (reg.test(param)) {
      //     alert('您输入的登陆信息中含有特殊字符!')
      //     return false
      //   }
      // },
      login () {
        const self = this
        self.loading = true
        if (!self.username && !self.password) {
          self.loading = false
          self.errortext = '您的登录信息不可为空！'
        } else if (!/[ ~!@#$%^&*()+={}|;:'",./<>?]+/.test(self.username) && !/[ ~!@#$%^&*()+={}|;:'",./<>?]+/.test(self.password)) {
          self.loading = false
          self.errortext = '您输入的登陆信息中含有特殊字符!'
        } else {
          // axios
          // self.$http({
          //   method: 'post',
          //   type: 'post',
          //   url: '/user/login.do?',
          //   data: {
          //     userno: md5(self.username),
          //     pwd: md5(self.password),
          //     date: self.date,
          //     encode: md5(base64.encode(self.code))
          //   },
          //   dataType: 'json'
          // })
          //   .then((res) => {
          //     console.log(res.data)
          //   })
          //   .catch((err) => {
          //     console.log(err)
          //   })
          // 存登录状态和信息
          self.loading = false
          self.errortext = '成功'
          self.setCookies('username', self.username, 5)
          window.sessionStorage.setItem('username', self.username)
          setTimeout(function () {
            window.sessionStorage.removeItem('username')
          }, 1000 * 60 * 30)
          self.login = true
          self.$store.commit('isLogin', true)
          self.$router.push('/home')
        }
      },
      getCode () {
        this.date = new Date().getTime()
        let imgpath = 'http://localhost:8080/fbchannel/vail/autoImg.do?date=' + this.date
        document.getElementById('img').setAttribute('src', imgpath)
      }
    }
  }
</script>

<style scoped>
  html, body, .login-wrap {
    overflow: hidden;
  }
  img {
    cursor: pointer;
  }
  .login-wrap {
    height: 1000px;
    background-color: #F4F4F4;
  }
  header {
    background-color: #f9f9f9;
    height: 65px;
  }
  .logo {
    margin-left: 17%;
    padding: 12px 0;
  }
  .logo img {
    padding-right: 18px;
    border-right: 1px solid #adadad;
  }
  .logo span {
    padding-left: 14px;
    position: relative;
    top: -14px;
    font-size: 20px;
    font-weight: bold;
  }
  main {
    background-color: #F4F4F4;
    margin-left: auto;
    margin-right: auto;
    text-align: center;
    width: 400px;
  }
  .login-form {
    margin-top: 45%;
    width: 400px;
    height: 350px;
    background-color: #fff;
    border-radius: 4px;
  }
  .login-content {
    width: 100%;
    margin: 0 auto;
    padding-top: 40px;
    text-align: center;
  }
  .login-group {
    margin-bottom: 20px;
    text-align: center;
    font-size: 14px;
  }
  .login-group h3 {
    color: #D4001D;
    font-size: 20px;
  }
  .login-group input {
    padding: 10px 86px 10px 10px;
    font-size: 14px;
    border: 1px solid #ccc;
    border-radius: 4px;
  }
  .login-group button {
    padding: 10px 120px 10px 120px;
    border: 1px solid #ccc;
    border-radius: 4px;
    background-color: #D4001D;
    color: #fff;
  }

</style>
