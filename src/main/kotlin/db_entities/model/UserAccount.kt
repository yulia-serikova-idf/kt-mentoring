package db_entities.model

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Table
class UserAccount {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  val id: Int? = null

  @Column(name = "email")
  val email: String? = null

  @Column(name = "name")
  val name: String? = null

  @Column(name = "login")
  val login: String? = null

  @ManyToOne
  @JoinColumn(name = "role_id", referencedColumnName = "id")
  val role: Role? = null
}