<template>
  <div class="app">
    {{msg}}
  </div>
</template>

<script>
export default {
  name: "app",
  data() {
    return {
      msg: "這是首頁"
    };
  }
};
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>

</style>
