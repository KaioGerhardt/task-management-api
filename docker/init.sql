CREATE TABLE "tasks" (
	"id" BIGINT NOT NULL,
	"created_at" TIMESTAMP NULL DEFAULT NULL,
	"description" VARCHAR(255) NULL DEFAULT NULL,
	"due_date" TIMESTAMP NULL DEFAULT NULL,
	"priority" VARCHAR(255) NULL DEFAULT NULL,
	"status" VARCHAR(255) NULL DEFAULT NULL,
	"title" VARCHAR(255) NULL DEFAULT NULL,
	PRIMARY KEY ("id"),
	CONSTRAINT "tasks_priority_check" CHECK ((((priority)::text = ANY ((ARRAY['LOW'::character varying, 'MEDIUM'::character varying, 'HIGH'::character varying])::text[])))),
	CONSTRAINT "tasks_status_check" CHECK ((((status)::text = ANY ((ARRAY['PENDING'::character varying, 'IN_PROGRESS'::character varying, 'COMPLETED'::character varying])::text[]))))
)
;
