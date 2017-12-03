<template>
  <div class="app">
      <div class="input-group">
          <input v-model="userName" type="text" class="form-control" placeholder="使用者名稱" readonly>
          <input v-model="msg" type="text" class="form-control" placeholder="輸入訊息" aria-describedby="basic-addon1">
          <button type="button" class="btn btn-success" v-bind:disabled="classObject" v-on:click="insertMsg">{{btnValue}}</button>
      </div>
      <br/>
      <div id='roadbar' class="progress">
        <div class="progress-bar progress-bar-striped bg-info progress-bar-animated" role="progressbar" v-bind:style="{ width: addWidth }">{{loading}}</div>
      </div>
      <div class="scroll justify-content-md-center">
        <div class="card col-sm-10" v-for="obj in allMessages" v-bind:key="obj.timestamp">
            <div class="card-header">留言者：{{obj.user}}</div>
            <div class="card-body">
            <blockquote class="blockquote mb-0">
              <p>{{obj.msg}}</p>
              <footer class="blockquote-footer">於 {{obj.timestamp}} 留言</footer>
            </blockquote>
            </div>
        </div>
      </div>
  </div>
</template>

<script>
import * as firebase from "firebase";
import * as moment from "moment";
import config from "@/config/config";

let app = firebase.initializeApp(config);
const db = app.database().ref("/messages/");

export default {
  name: "app",
  data() {
    return {
      addWidth: "0%",
      loading: "0%",
      userName: this.$route.params.userId,
      msg: "",
      allMessages: [],
      btnValue: "Send",
      classObject: false,
      time: 10
    };
  },
  methods: {
    insertMsg() {
      let vm = this;
      if (vm.msg === "") {
        return alert("請輸入訊息！");
      }
      let timestamp = Math.floor(Date.now() / 1000);
      db.child(timestamp).set({
        user: vm.userName,
        msg: vm.msg,
        timestamp: moment.unix(timestamp).format("HH:mm")
      });
      vm.msg = "";
      // this.classObject = true;
    },
    loadBarNum(width) {
      this.addWidth = width;
      this.loading = width;
    }
  },
  mounted() {
    let vm = this;
    setTimeout(() => {
      this.loadBarNum("100%");
    }, "1500");
    db.orderByChild("timestamp").on("value", function(e) {
      let firebaseObj = e.val(),
        newMsg = [];
      for (var val in firebaseObj) {
        newMsg.unshift(firebaseObj[val]);
      }
      vm.allMessages = newMsg;
      vm.loadBarNum("50%");
    });
    setTimeout(() => {
      $("#roadbar").hide();
    }, "2500");
  }
};
</script>
<style scoped>
h1,
a {
  color: #42b983;
}
.scroll {
  padding-left: 15%;
  height: 700px;
  overflow: auto;
}
</style>
