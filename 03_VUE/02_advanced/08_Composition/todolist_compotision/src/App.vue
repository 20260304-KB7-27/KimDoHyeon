<template>
  <div>
    <h1>:: TodoList App</h1>
    <InputBox @add-todo="addTodo"></InputBox>
    <TodoList
      :todo-list="todoList"
      @toggle-complete="toggleComplete"
      @delete-todo="deleteTodo"
    ></TodoList>
  </div>
</template>

<script setup>
import InputBox from './components/InputBox.vue';
import TodoList from './components/TodoList.vue';
import { ref } from 'vue';

let ts = new Date().getTime();
const todoList = ref([
  { id: ts, todo: '자전거 타기', completed: false },
  { id: ts + 1, todo: '딸과 공원 산책', completed: true },
  { id: ts + 2, todo: '일요일 애견 카페', completed: false },
  { id: ts + 3, todo: 'Vue 원고 집필', completed: false },
]);

// todo 생성
const addTodo = (newTodo) => {
  todoList.value.push(newTodo);
};

// todo 완/미완 토글
const toggleComplete = (id) => {
  // index 찾기
  console.log(id);

  let index = todoList.value.findIndex((item) => id === item.id);
  console.log(index);

  todoList.value[index].completed = !todoList.value[index].completed;
};

// todo 삭제
const deleteTodo = (id) => {
  // index 찾기
  let index = todoList.value.findIndex((item) => item.id === id);

  // todoList.value = todoList.value.filter((itme) => item.id !== id); // 이건 index 찾을 필요 없음.
  todoList.value.splice(index, 1);
};
</script>

<style lang="scss" scoped></style>
