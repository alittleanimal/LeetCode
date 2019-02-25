public class DeleteDuplicateEmails {

    private String test;

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    /**
     * 编写一个 SQL 查询，来删除 Person 表中所有重复的电子邮箱，重复的邮箱里只保留 Id 最小 的那个。
     * +----+------------------+
     | Id | Email            |
     +----+------------------+
     | 1  | john@example.com |
     | 2  | bob@example.com  |
     | 3  | john@example.com |
     +----+------------------+
     Id 是这个表的主键。


     Delete from Person where Email in
     (Select Email from (Select Email from Person group by Email having count(*) > 1) t2)
     and Id not in
     (Select Id from (Select min(Id) as Id from Person group by Email having count(*) > 1) t1);

     Best answer:
     DELETE p1 FROM Person p1,
     Person p2
     WHERE
     p1.Email = p2.Email AND p1.Id > p2.Id
     */
}
