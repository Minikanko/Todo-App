<template>
    <div class="container">
        크기 : {{TodoList.length}}
        <b-list-group>
            <b-list-group-item href="#" v-for="todo in TodoList" v-bind:key="todo.seq"  class="flex-column align-items-start">
                <div class="d-flex w-100 justify-content-between">
                <h5 class="mb-1">{{todo.context}}</h5>
                <small>{{todo.targetDt}}</small>
                </div>

                <p class="mb-1">
                {{todo.regId}}
                </p>

                <small>{{todo.isComplete}}</small>
            </b-list-group-item>
        </b-list-group>
       <a v-if="TodoList.length==0" class="list-group-item list-group-item-action " aria-current="true">
                게시물이 없습니다.
        </a>
  </div>
</template>
    
<script>
export default {
  name: 'Home',
  components: {
  },
  data(){
      return{
          TodoList : [],
      }
  },
  methods:{
      getList(){
        fetch('http://localhost:8070/todo/list/')     //브라우저에 내장되어있는 fetch라이브러리(비동기 라이브러리)
        .then(response => response.json())    //json 객체의 응답을 자바스크립트 객체로 변환
        .then(response => {
            console.log(response);
            this.TodoList = response.data;
        });
      },
  },
//   watch:{
//       TodoList(){},
//   },

  mounted(){
      this.getList()
  }
}
</script>