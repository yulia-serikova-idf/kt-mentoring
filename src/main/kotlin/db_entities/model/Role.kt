package db_entities.model

import javax.persistence.Column
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Table
class Role {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id", nullable = false)
  val id: Int? = null

  @Column(name = "description", nullable = false)
  val description: String? = null

  @Column(name = "name", nullable = false)
  val name: String? = null
}