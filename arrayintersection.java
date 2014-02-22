  public static int[] ArrayIntersection(int[] arr1, int[] arr2)
        {
            Dictionary<int, bool> hashTable = new Dictionary<int, bool>();

            for (int i = 0; i < arr1.Length; i++)
            {
                if (!hashTable.ContainsKey(arr1[i]))
                { hashTable.Add(arr1[i], true); }
            }

            List<int> list = new List<int>();

            for (int i = 0; i < arr2.Length; i++)
            {
                if (hashTable.ContainsKey(arr2[i]))
                {
                    list.Add(arr2[i]);
                }
            }


            return list.ToArray();
        }