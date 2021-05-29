<template>
    <div class="container">
        <div class="todoapp">
      <h1>TodoList</h1>
      <input
        id="new-todo-title"
        class="new-todo"
        placeholder="할일을 추가해주세요"
        autofocus
      />
      <main>
        <input class="toggle-all" type="checkbox" />
        <ul id="todo-list" class="todo-list" v-for="todo in TodoList" v-bind:key="todo.seq">
           <li :id="todo.seq" class="false">
                <div class="view">
                    <input class="toggle" type="checkbox" :id="todo.seq" :false="todo.isComplete.label">
                    <label class="label">{{todo.context}}</label>
                    <button class="destroy" :id="todo.seq"></button>
                </div>
                <input class="edit" value="호">
            </li>
        </ul>
      </main>
    </div>
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
        .then(response => response.json())             //json 객체의 응답을 자바스크립트 객체로 변환
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