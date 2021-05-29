<template>
    <b-container class="bv-example-row">
            <b-col md="auto">
            <b-calendar v-model="value" @context="onContext" locale="en-US"></b-calendar>
            </b-col>
            <b-col>
            <p>Value: <b>'{{ value }}'</b></p>
            <p class="mb-0">Context:</p>
            <pre class="small">{{ context }}</pre>
            </b-col>
    </b-container>
</template>

<script>
 export default {
    data() {
      return {
        value: '',
        context: null
      }
    },
    methods: {
      onContext(ctx) {
        this.context = ctx
      }
    }
  }
</script>