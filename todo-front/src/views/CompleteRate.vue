<template>
    <b-container class="bv-example-row" >
            <b-col md="auto">
                <b-calendar block v-model="value" @context="onContext" locale="kr"></b-calendar>
            </b-col>
            <b-col>
            <p class="mb-0">완료율: {{ completeRate }}</p>
            </b-col>
    </b-container>
</template>

<script>
 export default {
    data() {
      return {
        value: '',
        completeRate: null
      }
    },
    methods: {
      onContext(ctx) {
        this.completeRate='-';
        let targetDt = ctx.selectedYMD;

        fetch('http://localhost:8070/todo/completeRate/'+targetDt)     //브라우저에 내장되어있는 fetch라이브러리(비동기 라이브러리)
        .then(response => response.json())             //json 객체의 응답을 자바스크립트 객체로 변환
        .then(response => {
            if(response.code==="SUCCESS"){
                 console.log(response);
                 this.completeRate = response.data.completeRate;
            }
            else if(response.code==="ERROR"){
                alert("서버오류가 발생했습니다. 다시 한번 시도해보시기를 바랍니다. 만약 지속적으로 발생시 담당자에게 문의바랍니다.");
            }
        });
      }
    }
  }
</script>