<template>
  <div>
    <input type="text" v-model.trim="newTodo" />
    <button @click="addTodo">추가</button>
  </div>
</template>
<script setup>
import { ref } from 'vue';
const newTodo = ref('');

const emit = defineEmits(['add-todo']);
const addTodo = () => {
  console.log(newTodo.value);
  emit('add-todo', {
    id: new Date().getTime(),
    todo: newTodo.value,
    completed: false,
  });
  newTodo.value = '';
};
</script>
