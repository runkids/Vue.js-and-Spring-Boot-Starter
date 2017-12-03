<<template>
  <div class="singup">
    <div class="col-lg-3">
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">X</span>
                <input type="text" v-model="userId" class="form-control" placeholder="帳號" aria-label="userId" aria-describedby="basic-addon1">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">X</span>
                <input type="password" v-model="userPwd" class="form-control" placeholder="密碼" aria-label="userPwd" aria-describedby="basic-addon1">
            </div>
        </div>
        <div class="form-group">
            <div class="input-group">
                <span class="input-group-addon" id="basic-addon1">X</span>
                <input type="text" v-model="userName" class="form-control" placeholder="暱稱" aria-label="userId" aria-describedby="basic-addon1">
            </div>
        </div>
        <button type="submit" v-on:click="singUp" class="btn btn-primary">Submit</button>
    </div>
  </div>
</template>
<<script>
export default {
  name:"singup",
  data(){
      return {
          userId:"",
          userPwd:"",
          userName:""
      }
  },
  methods:{
    singUp(){
        let vm = this;
        axios.post("/json/singup", {
            userId:vm.userId,
            userPwd:vm.userPwd,
            userName:vm.userName
        }).then(response => { 
	        alert(response.data);
        }).catch(error => {
            console.log(error.response);
        });
    }
  },
  watch:{

  }
}
</script>
