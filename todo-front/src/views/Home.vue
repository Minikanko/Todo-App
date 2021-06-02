<template>
    <div class="container">
        <div class="todoapp">
             <h1>TodoList</h1>
                <input
                    id="todo-context"
                    class="new-todo"
                    placeholder="일정을 추가해주세요"
                    autofocus
                    v-on:keyup.enter="addList"/>
            <main>
                <input class="toggle-all" type="checkbox" />
                <ul id="todo-list" class="todo-list" v-for="todo in TodoList" v-bind:key="todo.seq">
                     <li :id="todo.seq" class="completed" v-if="todo.isComplete.code==='Y'">
                        <div class="view">
                            <input class="toggle" type="checkbox" :id="todo.seq" checked v-on:click="updateStatus">
                            <label class="label" v-on:dblclick="updateList">{{todo.context}}</label>
                            <button class="destroy" :id="todo.seq" v-on:click="deleteList"></button>
                        </div>
                    </li>
                    <li :id="todo.seq" class="false" v-else>
                        <div class="view">
                            <input class="toggle" type="checkbox" :id="todo.seq" false v-on:click="updateStatus">
                            <label class="label" :id="todo.seq">{{todo.context}}</label>
                            <button class="destroy" :id="todo.seq" v-on:click="deleteList"></button>
                        </div>
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
            if(response.code==="SUCCESS"){
                 console.log(response);
                 this.TodoList = response.data;
            }
            else if(response.code==="ERROR"){
                alert("서버오류가 발생했습니다. 다시 한번 시도해보시기를 바랍니다. 만약 지속적으로 발생시 담당자에게 문의바랍니다.");
            }
           
        });
    },
    addList(){
        let context = document.getElementById("todo-context").value;
        let regId  = "user1";
        let targetDt  = "2021-05-30";

        let todoListData = 
        {
            method: 'POST',
            body: JSON.stringify({context,regId,targetDt}),
            headers: {
                'Content-Type': 'application/json'
            }
        };

        fetch('http://localhost:8070/todo/save',todoListData)
        .then(response => response.json())
        .then(response =>{
            if(response.code==="SUCCESS"){
                alert("등록되었습니다.");
                document.getElementById("todo-context").value="";
                this.getList();
            }
            else if(response.code==="ERROR"){
                alert("서버오류가 발생했습니다. 다시 한번 시도해보시기를 바랍니다. 만약 지속적으로 발생시 담당자에게 문의바랍니다.");
            }
        });
    },
    updateStatus(e){
        let parentLi = e.target.parentElement.parentElement;
        let targetCheckBox = e.target;

        console.log(parentLi.className);
        console.log(parentLi.class==="false");
        e.target.parentElement.parentElement.className='completed';
        console.log(parentLi.className);
        if(parentLi.class==="false"){
            e.target.parentElement.parentElement.className='completed';
            targetCheckBox.checked ="true";
        }
        else{
            parentLi.className="false";
            targetCheckBox.checked ="false";
        }
            
    },
    updateList(){
        //let seq = e.target.id;
    },

    deleteList(e){
        let seq = e.target.id;

         let deleteData = 
        {
            method: 'DELETE',
        };
        fetch('http://localhost:8070/todo/'+seq,deleteData)
        .then(response => response.json())
        .then(response =>{
            if(response.code==="SUCCESS"){
                alert("삭제됐습니다");
                this.getList();
            }
            else if(response.code==="ERROR"){
                alert("서버오류가 발생했습니다. 다시 한번 시도해보시기를 바랍니다. 만약 지속적으로 발생시 담당자에게 문의바랍니다.");
            }
        });

    },

  },
  mounted(){
      this.getList()
  }
}
</script>