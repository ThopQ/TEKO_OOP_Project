<script setup lang="ts">
import { useFinanceStore } from "../stores/finance";
import FinanceCard from "@/components/FinanceCard.vue";

const finance = useFinanceStore();
</script>

<template>
  <FinanceCard :col-span="true">
    <template #title>Overview</template>

    <template #body>
      <h3
        class="text-2xl font-bold"
        :class="{
          'text-accent': finance.totalRevenue > 0,
          'text-secondary': finance.totalRevenue < 0,
        }"
      >
        CHF {{ finance.totalRevenue.toFixed(2) }}.-
        <span v-if="finance.isNice" class="ml-3">😏</span>
      </h3>
      <p>Some additional information...</p>
    </template>
  </FinanceCard>
</template>
