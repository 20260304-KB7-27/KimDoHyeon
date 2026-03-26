<script setup>
import { ref, computed } from 'vue';
import CoralSeaTab from './components/CoralSeaTab.vue';
import LeyteGulfTab from './components/LeyteGulfTab.vue';
import MidwayTab from './components/MidwayTab.vue';

// :is에 컴포넌트 객체를 전달
const tabs = ref([
  { id: 'CoralSeaTab', label: '산호해 해전' },
  { id: 'MidwayTab', label: '미드웨이 해전' },
  { id: 'LeyteGulfTab', label: '레이테만 해전' },
]);

/*
  동적 컴포넌트
  - is 속성을 사용하여 런타임에 렌더링할 컴포넌트를 동적으로 바꿀 수 있다.
  - Tav UI / 스텝 UI 에서 사용
  */
// :is에 컴포넌트 객체를 전달
const tabComponent = {
  CoralSeaTab,
  LeyteGulfTab,
  MidwayTab,
};

// 선택된 탭
const currentTabName = ref('CoralSeaTab');
const currentTab = computed(() => tabComponent[currentTabName.value]);

// 클릭됐을 때 currentTabName 변경
const changeTab = (tab) => {
  console.log(tab);
  currentTabName.value = tab;
};

// return {
//   tabs,
//   currentTab,
//   changeTab,
// };
</script>
<template>
  <div class="header">
    <h1 class="headerText">동적 컴포넌트</h1>
    <hr />
    <h1 class="headerText">태평양 전쟁의 해전</h1>
    <nav>
      <ul class="nav nav-tabs nav-fill">
        <li v-for="tab in tabs" :key="tab.id" class="nav-item">
          <a
            style="cursor: pointer"
            class="nav-link"
            :class="{ active: tab.id === currentTab }"
            @click="changeTab(tab.id)"
            >{{ tab.label }}</a
          >
        </li>
      </ul>
    </nav>
  </div>
  <div class="container">
    <!-- keep-alive로 인해서 한 번 만든 컴포넌트는 재사용됨.=시간 안 바뀜. -->
    <keep-alive include="MidwayTab,CoralSeaTab,LeyteGulfTab">
      <component :is="currentTab"></component>
    </keep-alive>
  </div>
</template>

<style>
.header {
  padding: 20px 0px 0px 20px;
}
.headerText {
  padding: 0px 20px 40px 20px;
}
.tab {
  padding: 30px;
}
</style>
