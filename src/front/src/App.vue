<template>
  <div class="app">
    <nav class="navbar navbar-expand-md navbar-dark bg-dark">
      <a class="navbar-brand" href="#">歡迎 {{loginUser}}!</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav mr-auto">
          <li class="nav-item">
            <router-link :to="'index'"><a @click="beActive($event)" class="nav-link active">首頁</a></router-link>
          </li>
          <li class="nav-item">
            <router-link  :to="{name:'chartroom',params: { userId: loginUser }}"><a @click="beActive($event)" class="nav-link">留言板</a></router-link>
          </li>
        </ul>
        <form class="form-inline my-2 my-lg-0">
          <button class="btn btn-outline-success my-2 my-sm-0" formaction="/logout" type="submit">登出</button>
        </form>
      </div>
    </nav>
    <div class="container-fluid">
      <div class="row"> 
        <nav class="col-sm-3 col-md-2 d-none d-sm-block bg-light sidebar">
          <ul class="nav nav-pills flex-column">
            <li class="nav-item">
              <a class="nav-link active" href="#">Overview <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Reports</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Analytics</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="#">Export</a>
            </li>
          </ul>
        </nav>
      <main role="main" class="col-sm-9 ml-sm-auto col-md-10 pt-3">
        <router-view></router-view>
      </main>
      </div>
    </div>
	</div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      loginUser: ""
    };
  },
  methods: {
    beActive: event => {
      $(".nav-link").removeClass("active");
      event.currentTarget.classList.add("active");
    }
  },
  beforeCreate() {
    let vm = this;
    axios.post("/json/getUserInfo").then(res => {
      vm.loginUser = res.data.loginUser;
    });
  }
};
</script>

<style lang="scss">
@import "~bootstrap/scss/bootstrap";
</style>
