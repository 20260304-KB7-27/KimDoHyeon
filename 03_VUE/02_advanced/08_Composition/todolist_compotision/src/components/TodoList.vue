<template>
  <div>
    <ul>
      <TodoItem
        v-for="todoItem in todoList"
        :key="todoItem.id"
        :todoItem="todoItem"
        @toggle-complete="toggleComplete"
        @delete-todo="deleteTodo"
      ></TodoItem>
    </ul>
  </div>
</template>

<script setup>
import TodoItem from './TodoItem.vue';

const props = defineProps({
  todoList: Array,
});

// 빌려오기
const emit = defineEmits(['toggle-complete', 'delete-todo']);
// 부모에게 전달
const toggleComplete = (id) => {
  emit('toggle-complete', id);
};
const deleteTodo = (id) => {
  emit('delete-todo', id);
};
</script>
